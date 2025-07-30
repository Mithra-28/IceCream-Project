package com.kce.icecream.service;

import com.kce.icecream.entity.Flavor;

import java.util.List;

public interface IceCreamService {
    Flavor findById(long id);

    Flavor addFlavor(Flavor flavor);

    Flavor updateById(Flavor flavor, long id);

    Flavor deleteById(long id);

    List<Flavor> findAll();
}
