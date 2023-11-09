package neilo.service;

import lombok.RequiredArgsConstructor;
import neilo.dto.ClientDto;
import neilo.dto.GroupDto;
import neilo.dto.GroupReadDto;
import neilo.entity.Group;
import neilo.mapper.GroupDtoMapper;
import neilo.mapper.GroupMapper;
import neilo.mapper.GroupReadDtoMapper;
import neilo.repository.GroupRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class GroupService {

    private final GroupRepository groupRepository;
    private final GroupReadDtoMapper groupReadDtoMapper;
    private final GroupMapper groupMapper;

    public GroupReadDto getById(Integer id) {
        Optional<GroupReadDto> groupReadDto = groupRepository.findById(id).map(groupReadDtoMapper::map);
        return groupReadDto.orElseThrow();
    }

    public List<GroupReadDto> getAllGroups() {
        return groupRepository.findAll()
                .stream()
                .map(groupReadDtoMapper::map)
                .collect(Collectors.toList());
    }

    @Transactional
    public void saveGroup(GroupDto groupDto) {
        Group group = groupMapper.map(groupDto);

        groupRepository.save(group);
    }

    @Transactional
    public void delete(Integer id) {
        groupRepository.deleteById(id);
    }

    @Transactional
    public void edit(GroupDto groupDto) {
        Optional<Group> currentGroup = groupRepository.findById(groupDto.getId());
        Group editedGroup = groupMapper.map(groupDto);
        currentGroup.ifPresent(group -> {
            group.setName(editedGroup.getName());
            group.setTeacher(editedGroup.getTeacher());
        });
    }

    public void saveClient(ClientDto clientDto) {

    }
}
