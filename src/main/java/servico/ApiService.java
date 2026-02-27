package servico;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aplication.dto.AddressDto;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiService {

    AddressDto dto = new AddressDto();

    public AddressDto getEndereco (String cep) {

        try {

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://viacep.com.br/ws/" + cep + "/json")).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper mapper = new ObjectMapper();
            dto = mapper.readValue(response.body(), AddressDto.class);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dto;
    }
}
