package code9.project.tennisplayerservice.service;

import code9.project.tennisplayerservice.dto.TennisPlayerDto;
import code9.project.tennisplayerservice.mapper.TennisPlayerMapper;
import code9.project.tennisplayerservice.model.TennisPlayerEntity;
import code9.project.tennisplayerservice.repository.TennisPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TennisPlayerServiceImpl implements TennisPlayerService {

    @Autowired
    private TennisPlayerMapper tennisPlayerMapper;

    @Autowired
    private TennisPlayerRepository tennisPlayerRepository;

    @Override
    public TennisPlayerDto addTennisPlayer(TennisPlayerEntity tennisPlayerEntity) {
        return tennisPlayerMapper.toTennisPlayerDto(tennisPlayerRepository.save(tennisPlayerEntity));
    }

    @Override
    public boolean removeTennisPlayer(int tennisPlayerId) {
        try {
            tennisPlayerRepository.deleteById(tennisPlayerId);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public List<TennisPlayerDto> getAllTennisPlayers() {
        return tennisPlayerMapper.toTennisPlayerDtos(tennisPlayerRepository.findAllByOrderByLastName());
    }

}
