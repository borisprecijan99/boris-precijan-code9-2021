package code9.project.tenniscourtservice.service;

import code9.project.tenniscourtservice.dto.TennisCourtDto;
import code9.project.tenniscourtservice.mapper.TennisCourtMapper;
import code9.project.tenniscourtservice.model.TennisCourtEntity;
import code9.project.tenniscourtservice.repository.TennisCourtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TennisCourtServiceImpl implements TennisCourtService {

    @Autowired
    private TennisCourtRepository tennisCourtRepository;

    @Autowired
    private TennisCourtMapper tennisCourtMapper;

    @Override
    public boolean addTennisCourt(TennisCourtEntity tennisCourtEntity) {
        try {
            tennisCourtRepository.save(tennisCourtEntity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean removeTennisCourt(int tennisCourtId) {
        try {
            tennisCourtRepository.deleteById(tennisCourtId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<TennisCourtDto> getAllTennisCourts() {
        return tennisCourtMapper.toTennisCourtDtos(tennisCourtRepository.findAllByOrderByName());
    }
}
