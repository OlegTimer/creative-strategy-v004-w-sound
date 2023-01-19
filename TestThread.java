import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.ShortMessage;

public  class TestThread implements Runnable{
    public void run()
    {
        try {
            Sol.player = null;
            Sol.player = MidiSystem.getSequencer();
            Sol.player.open();
        }catch (Exception e) {
        }
    }
    public   void play() {
        int item = Sol.sounditem;
        Sol.sounditem = 0;

        try {
            Sol.player.stop();
        } catch (Exception e) {
        }

        try {
            Sol.seq = null;
            Sol.track = null;
            Sol.issoundplayingnow = false;
        } catch (Exception e) {
        }

        if (item != 0) {
            try {
                Sol.issoundplayingnow = true;
                Sol.seq = new Sequence(Sequence.PPQ, 4);
                Sol.track = Sol.seq.createTrack();

                ShortMessage first = null;
                MidiEvent changeInstrument = null;

                if (item < 0) {
                    first = new ShortMessage();
                    first.setMessage(192, 1, 120, 0);
                    changeInstrument = new MidiEvent(first, 0);
                    Sol.track.add(changeInstrument);
                    Sol.track.add(makeevent(144, 1, 40, 100, 0));
                    Sol.track.add(makeevent(128, 1, 70, 100, 16));
                }

                if (item == 6 || item == 1006 || item == 2006 || item == 3006) {
                    first = new ShortMessage();
                    first.setMessage(192, 1, 115, 0);
                    changeInstrument = new MidiEvent(first, 0);
                    Sol.track.add(changeInstrument);
                    Sol.track.add(makeevent(144, 1, 70, 100, 0));
                    Sol.track.add(makeevent(128, 1, 70, 100, 16));
                }

                if (item == 7 || item == 1007 || item == 2007 || item == 3007 || item == 8 || item == 2008) {
                    first = new ShortMessage();
                    first.setMessage(192, 1, 118, 0);
                    changeInstrument = new MidiEvent(first, 0);
                    Sol.track.add(changeInstrument);
                    Sol.track.add(makeevent(144, 1, 70, 100, 0));
                    Sol.track.add(makeevent(128, 1, 70, 100, 16));
                }

                if (item == 5 || item == 1005 || item == 2005 || item == 3005) {
                    first = new ShortMessage();
                    first.setMessage(192, 1, 80, 0);
                    changeInstrument = new MidiEvent(first, 0);
                    Sol.track.add(changeInstrument);
                    Sol.track.add(makeevent(144, 1, 40, 100, 0));
                    Sol.track.add(makeevent(128, 1, 70, 100, 16));
                }

                if (item == 4 || item == 2004 || item == 2009 || item == 9) {
                    first = new ShortMessage();
                    first.setMessage(192, 1, 127, 0);
                    changeInstrument = new MidiEvent(first, 0);
                    Sol.track.add(changeInstrument);
                    Sol.track.add(makeevent(144, 1, 40, 90, 0));
                    Sol.track.add(makeevent(128, 1, 70, 100, 16));
                }

                if (item == 1011) {
                    first = new ShortMessage();
                    first.setMessage(192, 1, 127, 0);
                    changeInstrument = new MidiEvent(first, 0);
                    Sol.track.add(changeInstrument);
                    Sol.track.add(makeevent(144, 1, 40, 127, 0));
                    Sol.track.add(makeevent(144, 1, 40, 127, 3));
                    Sol.track.add(makeevent(144, 1, 40, 127, 6));
                    Sol.track.add(makeevent(128, 1, 70, 100, 16));
                }

                Sol.player.setSequence(Sol.seq);
                Sol.player.setTempoInBPM(120);
                Sol.player.start();
            } catch (Exception e) {
            }
        }

    }
    public  static MidiEvent makeevent(int comd, int chan, int freq, int vol, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, freq, vol);
            event = new MidiEvent(a, tick);
        } catch (Exception e) {
        }
        return event;
    }

}
