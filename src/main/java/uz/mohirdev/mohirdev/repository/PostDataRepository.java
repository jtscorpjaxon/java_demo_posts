package uz.mohirdev.mohirdev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.mohirdev.mohirdev.entity.PostData;

@Repository
public interface PostDataRepository extends JpaRepository<PostData,Long> {
}
