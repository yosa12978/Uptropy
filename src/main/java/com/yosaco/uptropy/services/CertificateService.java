package com.yosaco.uptropy.services;

import com.yosaco.uptropy.domain.Certificate;
import com.yosaco.uptropy.exceptions.NotFoundException;
import com.yosaco.uptropy.repositories.CertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificateService {
    @Autowired
    private CertificateRepository certificateRepository;

    private Certificate getByAddress(String address) {
        return this.certificateRepository.findByAddress(address)
                .orElseThrow(() -> new NotFoundException("Certificate not found"));
    }

    private List<Certificate> getAll(){
        return this.certificateRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    private Page<Certificate> getAll(int page){
        return this.certificateRepository.findAll(PageRequest.of(page, 50, Sort.by(Sort.Direction.DESC, "id")));
    }

    private Certificate createCertificate(Certificate certificate) {
        return this.certificateRepository.save(certificate);
    }

    private void deleteCertificate(Certificate certificate) {
        this.certificateRepository.delete(certificate);
    }
}
