package com.ssg.ssg_be.store.infrastructure;

import com.ssg.ssg_be.store.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
