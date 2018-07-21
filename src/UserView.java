import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class UserView {
    private User user = null;
    private JFrame userWindow;

    private JTextField userID;
    private JButton followUser;
    private JTextArea following;
    private JTextField tweet;
    private JButton postTweet;
    private JTextArea feed;
    private JPanel userPanel;
    private JPanel followPanel;
    private JPanel followingPanel;
    private JPanel tweetPanel;
    private JPanel feedPanel;
    private JTextField  last;
    
    private JLabel time;
    private JButton updateUser;

    private JScrollPane scrollFollowing;
    private JScrollPane scrollFeed;

    private static String x;
    
    public UserView(User user){
        this.user = user;

        
          //--------------------------------  User Window
        
        userWindow = new JFrame();

        
          //--------------------------------  User Panel
        
        userPanel = new JPanel();
        userPanel.setLayout(new GridBagLayout());
        followPanel = new JPanel();
        followPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        userPanel.add(followPanel, gbc);

        
        //-------------------------------- User ID Field
        userID = new JTextField();
        userID.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        followPanel.add(userID, gbc);

        // Follow User Button
        followUser = new JButton();
        followUser.setText("Follow User");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        followPanel.add(followUser, gbc);

        
         //---------------------------------  Following Panel
        
        followingPanel = new JPanel();
        followingPanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        userPanel.add(followingPanel, gbc);

        // Following Text Area
        List<User> followingList = user.getFollowing();
        String followingText = "Following:\n";
        for(User u : followingList){
            followingText += "- " + u.getID() + "\n";
        }
        following = new JTextArea();
        following.setText(followingText);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        scrollFollowing = new JScrollPane(following);
        followingPanel.add(scrollFollowing, gbc);

       
        tweetPanel = new JPanel();
        tweetPanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        userPanel.add(tweetPanel, gbc);

        // - ----------------------------------Tweet Text Field
        tweet = new JTextField();
        tweet.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        tweetPanel.add(tweet, gbc);

        //---------------------------------------- Post Tweet Button
        postTweet = new JButton();
        postTweet.setText("Post Tweet");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        tweetPanel.add(postTweet, gbc);

       
        feedPanel = new JPanel();
        feedPanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        userPanel.add(feedPanel, gbc);

        // Feed Text Area
        List<String[]> tweetFeed = user.getFeed();
        String f = "Monments:\n";
        
   	 long currentTime = System.currentTimeMillis();

     SimpleDateFormat formatter = new SimpleDateFormat("yyyy /MM /dd   HH£ºmm£ºss");

      Date date = new Date(currentTime);
        
        
        
        
        
        
        
        for(String[] nameTweet: tweetFeed){
        
            f += "[" + nameTweet[0] + "] " + nameTweet[1] + "[" + formatter.format(date)+ "]"+"\n";
            
        }
     
       
        feed = new JTextArea();
        feed.setText(f);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        scrollFeed = new JScrollPane(feed);
        feedPanel.add(scrollFeed, gbc);
        
        
        // label
        time = new JLabel();
         
         
        long currentTime1 = System.currentTimeMillis();

        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy /MM /dd HH£ºmm£ºss");

         Date date1 = new Date(currentTime1);

       

         time.setText(formatter1.format(date1)); 
         
        gbc.gridx =0;
        gbc.gridy =2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        scrollFeed = new JScrollPane(time);
        feedPanel.add(scrollFeed, gbc);
        //-------------------last
        last = new JTextField();
        gbc.gridx = 0;
        gbc.gridy =3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        scrollFeed = new JScrollPane(last);
        feedPanel.add(scrollFeed, gbc);
        
        
        
        
        
        
        
        //button update
        
        updateUser = new JButton();
        updateUser.setText("find last update user");
        
        gbc.gridx = 0;
        gbc.gridy =4;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        scrollFeed = new JScrollPane(updateUser);
        feedPanel.add(scrollFeed, gbc);
        
        //--------------
        
        
        
        
        
        

        setListeners();

        userWindow.add(userPanel);
        userWindow.setVisible(true);
        userWindow.setSize(700, 500);
    }
        private void setListeners() {
        followUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.followUser(user, userID.getText(), getInstance());
            }
        });
        postTweet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.postTweet(user, tweet.getText());
            }
        });
        
        
        updateUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            	
            	
            }
        });
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    public void notifyFollowingChange(){
        List<User> followingList = user.getFollowing();
        String followingText = "Following:\n";
        for(User u : followingList){
            followingText += "- " + u.getID() + "\n";
        }
        System.out.println(followingText);
        following.setText(followingText);
    }

    public void notifyTweetChange(){
        List<String[]> tweetFeed = user.getFeed();
        String feedText = "Feed:\n";
        
        
        long currentTime = System.currentTimeMillis();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy /MM /dd   HH£ºmm£ºss");

         Date date = new Date(currentTime);
         
        for(String[] nameTweet: tweetFeed){
            feedText += "[" + nameTweet[0] + "] " + nameTweet[1] + " ["+formatter.format(date)+"]" + "\n";
           
        }
        feed.setText(feedText);
       
		
    }

    public UserView getInstance(){
        return this;
    }
    
    
}



