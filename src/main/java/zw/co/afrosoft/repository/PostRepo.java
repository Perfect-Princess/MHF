package zw.co.afrosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.afrosoft.model.Post;

public interface PostRepo extends JpaRepository<Post,Long> {


}
