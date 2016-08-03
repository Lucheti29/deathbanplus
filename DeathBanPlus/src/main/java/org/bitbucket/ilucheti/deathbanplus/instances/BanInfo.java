package org.bitbucket.ilucheti.deathbanplus.instances;

public class BanInfo {

	private String _reason = "";
	private long _startedTime = 0;
	private long _endTime = 0;
	private boolean _banned = false;
	private int _timesBanned = 0;
	
	public BanInfo(String reason, long startedTime, long endTime, boolean banned, int timesBanned)
	{
		_reason = reason;
		_startedTime = startedTime;
		_endTime = endTime;
		_banned = banned;
		_timesBanned = timesBanned;
	}
	
	public String getReason()
	{
		return _reason;
	}
	
	public long getStartedTime()
	{
		return _startedTime;
	}
	
	public long getEndTime()
	{
		return _endTime;
	}
	
	public int getTimesBanned()
	{
		return _timesBanned;
	}
	
	public boolean isCurrentlyBanned()
	{
		return _banned;
	}
	
	public void unban()
	{
		_startedTime = 0;
		_endTime = 0;
		_reason = "Not banned";
		_banned = false;
	}
	
	public void ban(long actualTime, long endTime, String reason)
	{
		_startedTime = actualTime;
		_endTime = endTime;
		_reason = reason;
		_banned = true;
		_timesBanned++;
	}
}
