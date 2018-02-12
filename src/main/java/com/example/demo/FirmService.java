package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service("firmService")
public class FirmService
{
    public static Firm createFirm()
    {
        return new Firm();
    }
}
