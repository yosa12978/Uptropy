package com.yosaco.uptropy.services;

import com.yosaco.uptropy.domain.Sign;
import com.yosaco.uptropy.exceptions.NotFoundException;
import com.yosaco.uptropy.repositories.SignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignService {

    @Autowired
    private SignRepository signRepository;

    public Sign getSignByAddress(String address){
        return this.signRepository.findByAddress(address)
                .orElseThrow(() -> new NotFoundException("Sign not found."));
    }

    public List<Sign> getSignsByAuthor(String username){
        return this.signRepository.findByUserUsername(username);
    }

    public Page<Sign> getSignsByAuthor(String username, int page){
        return this.signRepository.findByUserUsername(username,
                PageRequest.of(page, 50, Sort.by(Sort.Direction.DESC, "id")));
    }

    public Sign createSign(Sign sign){
        return this.signRepository.save(sign);
    }

    public void deleteSign(Sign sign){
        this.signRepository.delete(sign);
    }

}
