package ismail.demo.services;

import ismail.demo.exceptions.ProjectIdException;
import ismail.demo.exceptions.ProjectNotFoundException;
import ismail.demo.model.Project;
import ismail.demo.repository.ProjectRepository;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project saveOrUpdateProject(Long projectId, Project project) {

        //Logic
        if (projectId != null) {
            Project projectOptional = projectRepository.findByProjectIdentifier(project.getProjectIdentifier());
            if (projectId.equals( project.getId())) throw new ProjectIdException( "Project ID 's not the same");
            else if (projectOptional == null)
                throw new ProjectNotFoundException("Project ID: '" + projectOptional.getProjectIdentifier() + "' does not exists");

            else if (!projectOptional.getProjectIdentifier().equals(project.getProjectIdentifier())) {

                throw new ProjectIdException("Project ID is not updatable");
            }
        }

        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        } catch (Exception e) {
            throw new ProjectIdException("Project ID: '" + project.getProjectIdentifier().toUpperCase() + "' already exists. It has to be Unique.");
        }


    }
}
