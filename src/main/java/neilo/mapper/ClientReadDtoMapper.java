package neilo.mapper;

import lombok.RequiredArgsConstructor;
import neilo.dto.ClientReadDto;
import neilo.entity.Client;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ClientReadDtoMapper implements Mapper<Client, ClientReadDto> {

    private final GroupReadDtoMapper groupReadDtoMapper;

    @Override
    public ClientReadDto map(Client client) {
        return ClientReadDto.builder()
                .id(client.getId())
                .firstname(client.getFirstname())
                .lastname(client.getLastname())
                .middlename(client.getMiddlename())
                .birthday(client.getBirthday())
                .parentFirstname(client.getParentFirstname())
                .parentLastname(client.getParentLastname())
                .parentMiddlename(client.getParentMiddlename())
                .parentPhone(client.getParentPhone())
                .groupReadDto(groupReadDtoMapper.map(client.getGroup()))
                .build();
    }
}
