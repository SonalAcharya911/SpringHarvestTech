package com.xworkz.onlineauction.service;

import com.xworkz.onlineauction.dto.MemberDTO;

public interface AuctionService {
    boolean validateAndSave(MemberDTO dto);
}
