package courierPD;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name ="CompanyInfo")
public class CompanyInfo implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id //signifies the primary key
	@Column(name = "name", nullable = false, length = 30)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String name;
	
    @Column(name = "address", nullable = false, length = 30)
	private String address;
	
	@Column(name = "billRate", nullable = false, length = 5)
	private double billRate;
	
	@Column(name = "costPerBlock", nullable = false, length = 5)
	private int costPerBlock;
	
	@Column(name = "courierSpeed", nullable = false, length = 2)
	private int courierSpeed;
	
	@Column(name = "blocksToAMile", nullable = false, length = 2)
	private int blocksToAMile;
	
	@Column(name = "bonusTimeVariance", nullable = false, length = 2)
	private int bonusTimeVariance;
	
	@Column(name = "bonusOnTime", nullable = false, length = 5)
	private double bonusOnTime;
	
	@Column(name = "pickUpTimeAllowance", nullable = false, length = 2)
	private int pickUpTimeAllowance;
	
	@Column(name = "deliveryTimeAllowance", nullable = false, length = 2)
	private int deliveryTimeAllowance;
	
	// Constructor
	public CompanyInfo()
	{
		
	}
	
	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getAddress()
	{
		return this.address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}
	
	public double getBillRate()
	{
		return this.billRate;
	}

	public void setBillRate(double billRate)
	{
		this.billRate = billRate;
	}
	
	public int getCostPerBlock()
	{
		return this.costPerBlock;
	}

	public void setCostPerBlock(int costPerBlock)
	{
		this.costPerBlock = costPerBlock;
	}
	
	public int getCourierSpeed()
	{
		return this.courierSpeed;
	}

	public void setCourierSpeed(int courierSpeed)
	{
		this.courierSpeed = courierSpeed;
	}
	
	public int getBlocksToAMile()
	{
		return this.blocksToAMile;
	}

	public void setBlocksToAMile(int blocksToAMile)
	{
		this.blocksToAMile = blocksToAMile;
	}
	
	public int getBonusTimeVariance()
	{
		return this.bonusTimeVariance;
	}

	public void setBonusTimeVariance(int bonusTimeVariance)
	{
		this.bonusTimeVariance = bonusTimeVariance;
	}
	
	public double getBonusOnTime()
	{
		return this.bonusOnTime;
	}

	public void setBonusOnTime(double bonusOnTime)
	{
		this.bonusOnTime = bonusOnTime;
	}
	
	public int getPickUpTimeAllowance()
	{
		return this.pickUpTimeAllowance;
	}

	public void setPickUpTimeAllowance(int pickUpTimeAllowance)
	{
		this.pickUpTimeAllowance = pickUpTimeAllowance;
	}
	
	public int getDeliveryTimeAllowance()
	{
		return this.deliveryTimeAllowance;
	}

	public void setName(int deliveryTimeAllowance)
	{
		this.deliveryTimeAllowance = deliveryTimeAllowance;
	}
}
