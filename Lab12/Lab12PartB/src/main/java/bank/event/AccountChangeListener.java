package bank.event;

import bank.repository.TraceRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class AccountChangeListener {
    @Autowired
    TraceRecordRepository traceRecordRepository;
    @EventListener
    public void onEvent(AccountChangeEvent accountChangeEvent){
        System.out.println("Event:" + accountChangeEvent);
        traceRecordRepository.save(accountChangeEvent.toTraceRecord());

    }
}
