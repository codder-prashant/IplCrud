package com.crud.service;

import com.crud.entity.IplTeam;
import com.crud.repository.IplRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ServiceImpl  implements  IplService {


   private IplRepository iplRepository;

    public ServiceImpl(IplRepository iplRepository) {
        this.iplRepository = iplRepository;
    }

    @Override
    public IplTeam insertdata(IplTeam iplTeam) {
        return iplRepository.save(iplTeam);
    }

    @Override
    public List<IplTeam> getAllTeams() {
        return iplRepository.findAll();
    }

    @Override
    public IplTeam updateTeam(int id, IplTeam iplTeam) {
        IplTeam existingTeam = iplRepository.findById(id).get();
        existingTeam.setName(iplTeam.getName());
        existingTeam.setTrophies(iplTeam.getTrophies());
        existingTeam.setCaptainName(iplTeam.getCaptainName());

        return iplRepository.save(existingTeam);
    }

    @Override
    public void delete(int id) {
        IplTeam existingTeam = iplRepository.findById(id).get();
        iplRepository.delete(existingTeam);

    }
}
