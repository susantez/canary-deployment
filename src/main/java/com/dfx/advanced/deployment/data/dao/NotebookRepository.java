package com.dfx.advanced.deployment.data.dao;

import com.dfx.advanced.deployment.data.model.Notebook;
import org.springframework.data.repository.CrudRepository;


public interface NotebookRepository extends CrudRepository<Notebook, Long> {
}
