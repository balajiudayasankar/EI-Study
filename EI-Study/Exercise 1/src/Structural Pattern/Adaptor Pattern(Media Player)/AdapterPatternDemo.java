// Target interface
interface MediaPlayer {
    void play(String audioType, String fileName); // Method to play a file of a certain type
}

// Adaptee class
class AdvancedMediaPlayer {
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: " + fileName); // Play a VLC file
    }

    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: " + fileName); // Play an MP4 file
    }
}

// Adapter class
class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedMusicPlayer;

    // Constructor to initialize the appropriate player based on audio type
    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMusicPlayer = new AdvancedMediaPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMusicPlayer = new AdvancedMediaPlayer();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMusicPlayer.playVlc(fileName); // Play VLC file
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMusicPlayer.playMp4(fileName); // Play MP4 file
        }
    }
}

// Concrete class implementing the Target interface
class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file. Name: " + fileName); // Play MP3 file directly
        } else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
            mediaAdapter = new MediaAdapter(audioType); // Use adapter for other formats
            mediaAdapter.play(audioType, fileName); // Play the file using adapter
        } else {
            System.out.println("Invalid media. " + audioType + " format not supported"); // Invalid format
        }
    }
}

// Main class
public class AdapterPatternDemo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer(); // Create audio player

        audioPlayer.play("mp3", "beyond_the_horizon.mp3"); // Play MP3 file
        audioPlayer.play("mp4", "alone.mp4"); // Play MP4 file
        audioPlayer.play("vlc", "far_far_away.vlc"); // Play VLC file
        audioPlayer.play("avi", "mind_me.avi"); // Invalid format
    }
}
