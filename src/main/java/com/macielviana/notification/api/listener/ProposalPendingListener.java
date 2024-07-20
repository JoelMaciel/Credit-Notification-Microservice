package com.macielviana.notification.api.listener;

import com.macielviana.notification.domain.constants.MessageConstant;
import com.macielviana.notification.domain.entities.Proposal;
import com.macielviana.notification.domain.services.NotificationSnsService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProposalPendingListener {

    private final NotificationSnsService notificationSnsService;

    @RabbitListener(queues = "${rabbitmq.queue.proposal.pending}")
    public void proposalPending(Proposal proposal) {
        String message = String.format(MessageConstant.PROPOSAL_IN_ANALYSIS, proposal.getUser().getName());
        notificationSnsService.notification(proposal.getUser().getPhoneNumber(), message);
    }
}
