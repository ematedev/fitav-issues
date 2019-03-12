package it.ethica.esf.portlet.utility;


public class MatchInfoCurriculum {
	
	private long matchId;
	private long matchTypeId;
	private long qualificationId;
	
	public long getmatchId(){
		return matchId;
	}
	
	public long getmatchTypeId(){
		return matchTypeId;
	}
	
	public long getqualificationId(){
		return qualificationId;
	}
	
	public void setmatchId(long matchId){
		this.matchId = matchId;
	}
	
	public void setmatchTypeId(long matchTypeId){
		this.matchTypeId = matchTypeId;
	}
	
	public void setqualificationId(long qualificationId){
		this.qualificationId = qualificationId;
	}

}
