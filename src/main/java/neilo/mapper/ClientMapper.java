package neilo.mapper;

import lombok.RequiredArgsConstructor;
import neilo.dto.ClientDto;
import neilo.entity.Client;
import neilo.repository.GroupRepository;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ClientMapper implements Mapper<ClientDto, Client> {

    private final GroupRepository groupRepository;

    @Override
    public Client map(ClientDto clientDto) {
        return Client.builder()
                .firstname(clientDto.getFirstname())
                .lastname(clientDto.getLastname())
                .middlename(clientDto.getMiddlename())
                .birthday(clientDto.getBirthday())
                .parentFirstname(clientDto.getParentFirstname())
                .parentLastname(clientDto.getParentLastname())
                .parentMiddlename(clientDto.getParentMiddlename())
                .parentPhone(clientDto.getParentPhone())
                .group(groupRepository.findById(clientDto.getGroupId()).orElseThrow())
                .build();
    }
}
