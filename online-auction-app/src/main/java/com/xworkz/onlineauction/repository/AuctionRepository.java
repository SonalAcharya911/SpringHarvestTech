package com.xworkz.onlineauction.repository;

import com.xworkz.onlineauction.entity.MemberEntity;

public interface AuctionRepository {
    boolean save(MemberEntity memberEntity);
}
