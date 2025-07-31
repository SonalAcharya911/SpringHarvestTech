package com.xworkz.contact.repository;

import com.xworkz.contact.dto.ContactDTO;

public interface ContactRepo {
    public int save(ContactDTO contactDTO);
}
