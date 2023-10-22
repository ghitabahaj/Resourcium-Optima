package com.youcode.resourcium.Service;

import com.youcode.resourcium.Entities.Tache;
import com.youcode.resourcium.repository.TacheRepository;

import java.util.List;

public class TacheService {
    private final TacheRepository taskRepository;

    public TacheService(TacheRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Tache> getAllTasks() {
        return this.taskRepository.findAll();
    }

    public Tache getTaskById(int id) {
        return taskRepository.findById(id);
    }

    public Tache saveTask(Tache task) {
        return taskRepository.save(task);
    }

    public void updateTask(Tache task) {
        taskRepository.update(task);
    }

    public void deleteTask(int id) {
        taskRepository.delete(id);
    }

    public List<Tache> getTasksByEmployeeId(Long employeeId) {
        return taskRepository.getTasksByEmployeeId(employeeId);
    }
}
