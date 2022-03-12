package com.example.springbootconditionalapp.systemprofile;

public class ProdProfile implements SystemProfile {
    @Override
    public String getProfile() {
        return "Current profile is production";
    }
}
