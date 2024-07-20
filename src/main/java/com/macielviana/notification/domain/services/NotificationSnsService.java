package com.macielviana.notification.domain.services;

public interface NotificationSnsService {

    void notification(String phoneNumber, String message);
}
