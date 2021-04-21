/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import ejb.NewsItem;
import ejb.NewsItemFacadeLocal;
import java.util.List;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

/**
 *
 * @author alili
 */
@Named(value = "newsBean")
@RequestScoped
public class NewsBean {

    @Inject
    private NewsItemFacadeLocal facade;
    
    @Inject
    private JMSContext context;
    @Resource(lookup = "java:app/jms/NewsQueue")
    private javax.jms.Queue queue;

    private String headingText;
    private String bodyText;
    
    /**
     * Creates a new instance of NewsBean
     */
    public NewsBean() {
    }    
    
    void sendNewsItem(String heading, String body) {
        try {
            TextMessage message = context.createTextMessage();
            String msg_text = heading + "|" + body;
            message.setText(msg_text);
            
            context.createProducer().send(queue, message);
        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }
    
//    void sendNewsItem(String heading, String body) {
//        try {
//            ObjectMessage message = context.createObjectMessage();
//            NewsItem e = new NewsItem();
//            e.setHeading(heading);
//            e.setBody(body);
//            message.setObject(e);
//            context.createProducer().send(queue, message);
//        } catch (JMSException ex) {
//            ex.printStackTrace();
//        }
//    }

    public List<NewsItem> getNewsItems() {
        return this.facade.getAllNewsItems();
    }

    public String submitNews() {
        sendNewsItem(this.headingText, this.bodyText);
        return null;
    }
    
    public String getHeadingText() {
        return headingText;
    }

    public void setHeadingText(String headingText) {
        this.headingText = headingText;
    }

    public String getBodyText() {
        return bodyText;
    }

    public void setBodyText(String bodyText) {
        this.bodyText = bodyText;
    }

}
