package org.example.pages.objects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class Project extends AbstractUiObject {

    private final By preview = By.xpath(".//div[starts-with(@class,'projectPreview')]");
    private final By select = By.xpath(".//button[starts-with(@class,'projectSelect')]");
    private final By editDesign = By.xpath(".//a[@data-test='editMyProject']");
    private final By editNameIcon = By.xpath(".//input[@data-test='renameMyProject']");
    private final By name = By.xpath(".//input[@data-test='myProjectName']");
    private final By menu = By.xpath(".//div[starts-with(@class,'openTabsButton')]");

    public Project(SelenideElement container) {
        super(container);
    }

    public SelenideElement getSelect() {
        return getContainer().find(select);
    }

    public SelenideElement getEditDesign() {
        return getContainer().find(editDesign);
    }

    public SelenideElement getEditNameIcon() {
        return getContainer().find(editNameIcon);
    }

    public SelenideElement getName() {
        return getContainer().find(name);
    }

    public String getNameValue() {
        return getName().getAttribute("value");
    }

    public String getId() {
        return getContainer().getAttribute("data-id");
    }

    public SelenideElement getPreview() {
        return getContainer().find(preview);
    }

    public Menu getMenu() {
        return new Menu(getContainer().find(menu));
    }

    @Override
    public SelenideElement getContainer() {
        return super.getContainer().as("user project on My projects page");
    }

    public class Menu {

        private final SelenideElement menu;
        private final By exportButton = By.xpath(".//button[@data-value='export']");
        private final By duplicateButton = By.xpath(".//button[@data-value='copy']");
        private final By deleteButton = By.xpath(".//button[@data-value='delete']");

        Menu(SelenideElement menu) {
            this.menu = menu;
        }

        public SelenideElement getContainer() {
            return menu.as("Project menu buttons").hover();
        }

        public SelenideElement getExportButton() {
            return getContainer().parent().find(exportButton).as("Export project button");
        }

        public SelenideElement getDuplicateButton() {
            return getContainer().parent().find(duplicateButton).as("Duplicate project button");
        }

        public SelenideElement getDeleteButton() {
            return getContainer().parent().find(deleteButton).as("Delete project button");
        }
    }
}
