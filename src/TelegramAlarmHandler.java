import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;

public class TelegramAlarmHandler extends StreamHandler {

    @Override
    public void publish(LogRecord record) {

        if (isLoggable(record)) {
            String sendMessage = "https://api.telegram.org/bot8006714385:AAENRhFARP5jwCl13VzVj2b2uc_o4HR06oo/sendMessage";
            String chatId = "2123513095";
            String formatter = getFormatter().format(record);
            String bodyMessage = """
                    {
                        "chat_id" : "%s",
                        "text" : "%s"
                    }
                    """.formatted(chatId, formatter);

            try (HttpClient httpClient = HttpClient.newHttpClient()) {
                HttpRequest request = HttpRequest.newBuilder()
                        .POST(HttpRequest.BodyPublishers.ofString(bodyMessage))
                        .uri(URI.create(sendMessage))
                        .header("Content-Type", "application/json")
                        .build();
                httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public boolean isLoggable(LogRecord record) {
        return getFilter().isLoggable(record);
    }

}
