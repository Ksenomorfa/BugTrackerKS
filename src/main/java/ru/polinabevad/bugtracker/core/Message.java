package ru.polinabevad.bugtracker.core;

import ru.polinabevad.bugtracker.core.Task.*;

import javax.persistence.*;
import java.util.Calendar;


/**
 * Сообщение к задаче. Может поменять статус системы, поставить нового\изменить Автора\Исполнителя
 */
@Entity
@Table(name = "message")
public class Message {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "messageId_seq")
    @SequenceGenerator(name = "messageId_seq", sequenceName = "messageId_sequence", allocationSize = 1)
    @Id
    private int messageId;

    @Column
    private StatusType messageStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "messageAppointerId", insertable = true, updatable = false)
    private People messageAppointer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "messageAuthorId", insertable = true, updatable = false)
    private People messageAuthor;


    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar messageDate;
    @Column
    private String messageText;

    @OneToOne
    @JoinColumn(name = "taskId")
    private Task task;

    public Message() {
    }

    public Message(Task task) {
        this.task = task;
    }

    public Message(Task task, People messageAppointer, String messageText) {
        this.messageAuthor = task.getTaskAuthor();
        this.messageAppointer = messageAppointer;
        messageDate = Calendar.getInstance();
        this.task = task;
        //устанавливаем дату апдейта задачи датой сообщения
        task.setTaskUpdateDate(messageDate);
        //добавляем текст сообщения
        this.messageText = messageText;
        this.messageStatus = task.getTaskStatus();
    }

    public String toString() {
        return "Текст: " + messageText;
    }

    public void deleteMessage() {
    }

    public StatusType getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(StatusType status) {
        this.messageStatus = status;
    }

    public int getMessageId() {
        return messageId;
    }
    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public Calendar getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(Calendar messageDate) {
        this.messageDate = messageDate;
    }

}
