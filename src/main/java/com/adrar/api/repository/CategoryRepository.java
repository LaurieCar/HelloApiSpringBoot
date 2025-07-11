package com.adrar.api.repository;

import com.adrar.api.model.Category;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {
    boolean existsByLabel(@NotNull String label);
}
