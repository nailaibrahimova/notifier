package az.pashabank.exam.notifier.dao;

import az.pashabank.exam.notifier.dao.entity.DataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotifierRepository extends JpaRepository<DataEntity, Long> {
}
