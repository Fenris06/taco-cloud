package ru.fenris06.repository;

import ru.fenris06.model.TacoOrder;

public interface OrderRepository {
    TacoOrder save(TacoOrder order);
}
