package bank.service;

import bank.domain.TraceRecord;
import bank.repository.TraceRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TraceService {
    @Autowired
    TraceRecordRepository traceRecordRepository;
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void storesTrace(TraceRecord traceRecord) {
        traceRecordRepository.save(traceRecord);
    }
}
