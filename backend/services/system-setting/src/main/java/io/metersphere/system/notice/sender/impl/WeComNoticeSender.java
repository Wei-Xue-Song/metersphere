package io.metersphere.system.notice.sender.impl;

import io.metersphere.sdk.util.LogUtils;
import io.metersphere.system.domain.User;
import io.metersphere.system.notice.MessageDetail;
import io.metersphere.system.notice.NoticeModel;
import io.metersphere.system.notice.Receiver;
import io.metersphere.system.notice.sender.AbstractNoticeSender;
import io.metersphere.system.notice.utils.WeComClient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WeComNoticeSender extends AbstractNoticeSender {

    public void sendWeCom(MessageDetail messageDetail, NoticeModel noticeModel, String context) {
        List<String> userIds = noticeModel.getReceivers().stream()
                .map(Receiver::getUserId)
                .distinct()
                .collect(Collectors.toList());
        List<User> users = super.getUsers(userIds);
        List<String> mobileList = users.stream().map(User::getPhone).toList();
        LogUtils.info("企业微信收件人: {}", userIds);
        WeComClient.send(messageDetail.getWebhook(), messageDetail.getSubject()+": \n" + context, mobileList);
    }

    @Override
    public void send(MessageDetail messageDetail, NoticeModel noticeModel) {
        String context = super.getContext(messageDetail, noticeModel);
        sendWeCom(messageDetail, noticeModel, context);
    }

}
