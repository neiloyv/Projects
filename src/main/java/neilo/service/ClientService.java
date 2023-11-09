package neilo.service;

import lombok.RequiredArgsConstructor;
import neilo.dto.ClientDto;
import neilo.dto.ClientReadDto;
import neilo.dto.GroupReadDto;
import neilo.entity.Client;
import neilo.mapper.ClientMapper;
import neilo.mapper.ClientReadDtoMapper;
import neilo.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientReadDtoMapper clientReadDtoMapper;
    private final ClientMapper clientMapper;

    public List<ClientReadDto> findAll() {
        return clientRepository.findAll().stream()
                .map(clientReadDtoMapper::map)
                .collect(Collectors.toList());
    }

    @Transactional
    public void save(ClientDto clientDto) {
        Client newClient = clientMapper.map(clientDto);

        clientRepository.save(newClient);
    }

    public ClientReadDto findById(Long id) {
        return clientRepository.findById(id)
                .map(clientReadDtoMapper::map)
                .orElseThrow();
    }

    @Transactional
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    @Transactional
    public void update(ClientDto clientDto) {
        Client clientDb = clientRepository.findById(clientDto.getId()).orElseThrow();
        Client clientEdited = clientMapper.map(clientDto);

        clientDb.setFirstname(clientEdited.getFirstname());
        clientDb.setLastname(clientEdited.getLastname());
        clientDb.setMiddlename(clientEdited.getMiddlename());
        clientDb.setBirthday(clientEdited.getBirthday());
        clientDb.setParentFirstname(clientEdited.getParentFirstname());
        clientDb.setParentLastname(clientEdited.getParentLastname());
        clientDb.setParentMiddlename(clientEdited.getParentMiddlename());
        clientDb.setParentPhone(clientEdited.getParentPhone());
        clientDb.setGroup(clientEdited.getGroup());
    }
}
