package com.artemas.customer.requests;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {

}
