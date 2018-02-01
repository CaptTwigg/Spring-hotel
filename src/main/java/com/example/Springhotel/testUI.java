package com.example.Springhotel;

import com.vaadin.annotations.Theme;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.renderers.ButtonRenderer;
import com.vaadin.ui.renderers.NumberRenderer;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@SpringUI(path="/test")
@Theme("valo")
public class testUI extends UI {

  private ArrayList<Person> persons = Server.getArray();


  // Initialization of UI
  @Override
  protected void init(VaadinRequest vaadinRequest) {

    GridLayout mainGrid = new GridLayout(16, 16);
    mainGrid.addStyleName("example-gridlayout");
    mainGrid.setSizeFull();

    mainGrid.addComponent(tab(), 10, 0, 15, 15);

    Button button = new Button("Redirect to manager page");
    Button button2 = new Button("Test button");
    Button button3 = new Button("Enable/disable test button");
    button.addClickListener(click -> Page.getCurrent().setLocation("manager"));
    button2.addClickListener(click -> new Notification("Hello I'am test button :)").show(Page.getCurrent()));
    button3.addClickListener(click -> {
      if( button2.isEnabled())
        button2.setEnabled(false);
      else
      button2.setEnabled(true);
    });

    mainGrid.addComponent(button,0,0);
    mainGrid.addComponent(button2,0,1);
    mainGrid.addComponent(button3,0,2);

    Panel panel = new Panel("Panel Text");
    panel.setHeight(100.0f, Unit.PERCENTAGE);
    final VerticalLayout contentLayout = new VerticalLayout();
    contentLayout.setWidth(500, Unit.PIXELS);
    contentLayout.setHeight(100.f, Unit.PERCENTAGE);
    contentLayout.setSpacing(false);
    contentLayout.addComponent(new Label(text(), ContentMode.HTML));

    panel.setContent(contentLayout);


    mainGrid.addComponent(panel,1,0,6,8);

    setContent(mainGrid);

  }

  private TabSheet tab() {
    TabSheet sample = new TabSheet();
    sample.setHeight(100.0f, Unit.PERCENTAGE);
    sample.addStyleName(ValoTheme.TABSHEET_FRAMED);
    sample.addStyleName(ValoTheme.TABSHEET_PADDED_TABBAR);

    for (int i = 1; i < 8; i++) {
      final Label label = new Label(text(), ContentMode.HTML);
      label.setWidth(100.0f, Unit.PERCENTAGE);

      final VerticalLayout layout = new VerticalLayout(data());
      layout.setMargin(true);

      sample.addTab(data(), "Tab " + i);
    }
    return sample;
  }



  private Grid data() {
    Grid<Person> grid = new Grid<>();


    grid.setCaption("Double click to edit");
    grid.setSizeFull();
    grid.setSelectionMode(Grid.SelectionMode.NONE);
    grid.setItems(persons);


    TextField nameEditor = new TextField();
    TextField fieldEditLast = new TextField();

    grid.addColumn(Person::getName)
      .setEditorComponent(nameEditor, Person::setName)
      .setCaption("First Name")
      .setExpandRatio(2)
      .setMinimumWidth(150)
    ;

    grid.addColumn(Person::getLast_name)
      .setEditorComponent(fieldEditLast, Person::setLast_name)
      .setCaption("Last Name")
      .setExpandRatio(2)
      .setMinimumWidth(150)
    ;



    grid.getEditor().setEnabled(true);

    return grid;
  }

  private String text() {
    return "Venenatis. Nullam risus massa, egestas in, facilisis tristique, molestie sed, mi. Duis euismod turpis sit amet quam. Vestibulum ornare felis eget dolor. Phasellus ac urna vel sapien lacinia adipiscing. Donec egestas felis id mi. Sed erat. Vestibulum porta vulputate neque. Maecenas scelerisque, sem id sodales pretium, sem mauris rhoncus magna, at scelerisque tortor mauris nec dui. Nullam blandit rhoncus velit. Nam accumsan, enim id vestibulum feugiat, lorem nibh placerat urna, eget laoreet diam tortor at lorem. Suspendisse imperdiet consectetur dolor. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut ut massa eget erat dapibus sollicitudin. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Pellentesque a augue. Praesent non elit. Duis sapien dolor, cursus eget, pulvinar eget, eleifend a, est. Integer in nunc. Vivamus consequat ipsum id sapien. Duis eu elit vel libero posuere luctus. Aliquam ac turpis. Aenean vitae justo in sem iaculis pulvinar. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Aliquam sit amet mi. \n" +
      "Aenean auctor, mi sit amet ultricies pulvinar, dui urna adipiscing odio, ut faucibus odio mauris eget justo. Mauris quis magna quis augue interdum porttitor. Sed interdum, tortor laoreet tincidunt ullamcorper, metus velit hendrerit nunc, id laoreet mauris arcu vitae est. Nulla nec nisl. Mauris orci nibh, tempor nec, sollicitudin ac, venenatis sed, lorem. Quisque dignissim tempus erat. Maecenas molestie, pede ac ultrices interdum, felis neque vulputate quam, in sodales felis odio quis mi. Aliquam massa pede, pharetra quis, tincidunt quis, fringilla at, mauris. Vestibulum a massa. Vestibulum luctus odio ut quam. Maecenas congue convallis diam. Cras urna arcu, vestibulum vitae, blandit ut, laoreet id, risus. Ut condimentum, arcu sit amet placerat blandit, augue nibh pretium nunc, in tempus sem dolor non leo. Etiam fringilla mauris a odio. Nunc lorem diam, interdum eget, lacinia in, scelerisque sit amet, purus. Nam ornare. \n" +
      "Donec placerat dui ut orci. Phasellus quis lacus at nisl elementum cursus. Cras bibendum egestas nulla. Phasellus pulvinar ullamcorper odio. Etiam ipsum. Proin tincidunt. Aliquam aliquet. Etiam purus odio, commodo sed, feugiat volutpat, scelerisque molestie, velit. Aenean sed sem sit amet libero sodales ultrices. Donec dictum, arcu sed iaculis porttitor, est mauris pulvinar purus, sit amet porta purus neque in risus. Mauris libero. Maecenas rhoncus. Morbi quis nisl. \n" +
      "Vestibulum laoreet tortor eu elit. Cras euismod nulla eu sapien. Sed imperdiet. Maecenas vel sapien. Nulla at purus eu diam auctor lobortis. Donec pede eros, lacinia tincidunt, tempus eu, molestie nec, velit. Nullam ipsum odio, euismod non, aliquet nec, consequat ac, felis. Duis fermentum mauris sed justo. Suspendisse potenti. Praesent at libero sit amet ipsum imperdiet fermentum. Aliquam enim nisl, dictum id, lacinia sit amet, elementum posuere, ipsum. Integer luctus dictum libero. Pellentesque sed pede sed nisl bibendum porttitor. Phasellus tempor interdum nisi. Mauris nec magna. Phasellus massa pede, vehicula sed, ornare at, ullamcorper ut, nisl. Sed turpis nisl, hendrerit sit amet, consequat id, auctor nec, arcu. Quisque fringilla tincidunt massa. In eleifend, nulla sed mollis vestibulum, mauris orci facilisis ante, id pharetra dolor ipsum vitae sem. Integer dictum. \n" +
      "Nunc ut odio. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec mauris tellus, dapibus vel, hendrerit vel, sollicitudin ut, ligula. Ut justo metus, accumsan placerat, ultrices sit amet, congue at, nulla. Integer in quam. Cras sollicitudin mattis magna. Vestibulum neque eros, egestas ut, tincidunt vel, ullamcorper non, ligula. Vivamus eu lacus. Donec rhoncus metus et odio. Donec est. Nulla facilisi. Suspendisse potenti. Etiam tempor pede nec ante. Vestibulum adipiscing velit vel neque. \n" +
      "Quisque ornare erat rhoncus lectus. Donec vitae ante at enim mollis egestas. Mauris convallis. Fusce convallis, nisl eu sagittis suscipit, risus ligula aliquam libero, in imperdiet neque mi non risus. Aenean dictum ultricies risus. Praesent ut ligula vitae purus ornare auctor. Cras tellus mauris, adipiscing ac, dignissim auctor, faucibus in, sem. Cras mauris libero, pharetra sit amet, lacinia eu, vehicula eleifend, sapien. Donec ac tellus. Sed eros dui, vulputate vel, auctor pharetra, tincidunt at, ipsum. Duis at dolor ac leo condimentum pulvinar. Donec molestie, dolor et fringilla elementum, nibh nibh iaculis orci, eu elementum odio turpis et odio. Phasellus fermentum, justo id placerat egestas, arcu nunc molestie ante, non imperdiet ligula lectus sed erat. Quisque sed ligula. Sed ac nulla. Nullam massa. \n" +
      "Sed a purus. Mauris non nibh blandit neque cursus scelerisque. Quisque ultrices sem nec dolor. Donec non diam ut dui consequat";
  }

}
