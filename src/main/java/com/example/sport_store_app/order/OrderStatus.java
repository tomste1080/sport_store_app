package com.example.sport_store_app.order;

public enum OrderStatus {
    PENDING,        // Zamówienie złożone, oczekuje na weryfikację / opłacenie
    PROCESSING,     // Przyjęte do realizacji, trwa kompletowanie w magazynie
    SHIPPED,        // Wysłane (przekazane kurierowi)
    DELIVERED,      // Doręczone do klienta
    CANCELLED       // Anulowane (przez klienta lub obsługę sklepu)
}
