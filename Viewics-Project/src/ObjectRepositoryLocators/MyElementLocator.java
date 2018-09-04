package ObjectRepositoryLocators;

import org.openqa.selenium.By;

public class MyElementLocator 
{

	
	
	public By homepage_logo=By.xpath("//div[@class='desktop-logoContainer']//a[@href]");
	public By homepage_search_textbox=By.xpath("//div[@class='desktop-query']//input[@placeholder='Search']");
	public By homepage_search_icon=By.xpath("//a[@class='desktop-submit']//span[contains(@class,'iconSearch sprites-search')]");
	public By itemfilterpage_brand_text=By.xpath("//span[text()='Brand']");
	public By itemfilterpage_brand_name_list=By.xpath("//ul[@class='brand-list']//input[@type='checkbox']");
	public By itemfilterpage_brand_checkbox_list=By.xpath("//label[@class='vertical-filters-label common-customCheckbox']//div[@class='common-checkboxIndicator']");
	public By itemfilterpage_clearall_text=By.xpath("//span[text()='clear all']");
	public By itemfilterpage_allfilter_items_list=By.xpath("//li[@class='product-base']//a[@href]");
	public By addtocartpage_myshoppingbag_button=By.xpath("//a[@class='desktop-cart']//span[@class='myntraweb-sprite desktop-iconBag sprites-bag']");
	public By addtocartpage_itemsize_list=By.xpath("//div[@class='size-buttons-size-buttons']//button[@class='size-buttons-size-button size-buttons-size-button-default']//p[@class='size-buttons-unified-size']");
	public By addtocartpage_addtocart_button=By.xpath("//button[@class='pdp-add-to-bag pdp-button pdp-flex pdp-center'][text()='ADD TO CART']");
	public By addtocartpage_item_name_text=By.xpath("//div[@class='pdp-price-info']//h1");
	public By myshoppingbagpage_allitemsname_list=By.xpath("//div[@class='prod-name']//a");
}
