package com.kce.icecream.repository;

import com.kce.icecream.entity.Flavor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IceCreamRepository extends JpaRepository<Flavor,Long> {
}
