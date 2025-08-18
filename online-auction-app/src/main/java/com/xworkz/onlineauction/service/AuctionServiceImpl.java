package com.xworkz.onlineauction.service;

import com.xworkz.onlineauction.dto.MemberDTO;
import com.xworkz.onlineauction.entity.MemberEntity;
import com.xworkz.onlineauction.repository.AuctionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuctionServiceImpl implements AuctionService{

    @Autowired
    private AuctionRepository repo;

    @Override
    public boolean validateAndSave(MemberDTO dto) {
        MemberEntity entity=null;
        if(dto!=null){
            entity=new MemberEntity();
            BeanUtils.copyProperties(dto,entity);
            return true;
        }
        boolean isSaved=repo.save(entity);
        return false;
    }
}
