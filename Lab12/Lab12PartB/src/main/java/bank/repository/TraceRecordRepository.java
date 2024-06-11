package bank.repository;

import bank.domain.TraceRecord;
import org.aspectj.weaver.tools.Trace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraceRecordRepository extends JpaRepository<TraceRecord, Long> {
}
