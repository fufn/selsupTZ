package xfufnx.selsup.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.client.WebClient;
import xfufnx.selsup.payload.request.DocumentCreateRequest;
import xfufnx.selsup.payload.response.DocumentCreateResponse;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class CrptApi {

    private String documentCreateUrl = "/lk/documents/create";
    private final WebClient webClient;
    private final Semaphore semaphore;
    private final ScheduledExecutorService scheduler;
    private final AtomicInteger madeRequests;

    public CrptApi (TimeUnit timeUnit, int requestLimit, WebClient webClient) {
        this.webClient = webClient;
        this.semaphore = new Semaphore(requestLimit);
        this.scheduler = Executors.newScheduledThreadPool(1);
        this.madeRequests = new AtomicInteger(0);
        long delay = timeUnit.toMillis(1);
        scheduler.scheduleAtFixedRate(() -> semaphore.release(madeRequests.getAndSet(0)), delay, delay, TimeUnit.MILLISECONDS);
    }

    public DocumentCreateResponse sendCreateDocumentRequest (DocumentCreateRequest documentCreateRequest, String signature) {
        log.info("Request [POST] to create document CRPT {}", documentCreateRequest);
        DocumentCreateResponse response = null;
        try {
            semaphore.acquire();
            response = webClient
                    .post()
                    .uri(documentCreateUrl)
                    .header("X-Signature", signature)
                    .bodyValue(documentCreateRequest)
                    .retrieve()
                    .bodyToMono(DocumentCreateResponse.class)
                    .block();
            madeRequests.incrementAndGet();
        } catch (Exception e) {
            log.error("Could not send request {}", documentCreateRequest, e);
        }
        return response;
    }

}
