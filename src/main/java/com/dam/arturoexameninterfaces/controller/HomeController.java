package com.dam.arturoexameninterfaces.controller;

import com.dam.arturoexameninterfaces.DAO.EquipoDAO;
import com.dam.arturoexameninterfaces.model.Equipo;
import com.dam.arturoexameninterfaces.util.Alertas;
import com.dam.arturoexameninterfaces.util.AppShell;
import com.dam.arturoexameninterfaces.util.View;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML
    public Label usuarioLogueadoLabel;
    @FXML
    public Button cerrarsesionBTN;
    @FXML
    public TableView<Equipo> tablaEquiposTV;
    @FXML
    public TableColumn<Equipo,Integer> idColumn;
    @FXML
    public TableColumn<Equipo,String> nombreColumn;
    @FXML
    public TableColumn<Equipo,Boolean> campeonColumn;
    @FXML
    public TableColumn<Equipo, LocalDate> fechaColumn;
    @FXML
    public TableColumn<Equipo,String> fotoColumn;
    @FXML
    public Label idCrudLabel;
    @FXML
    public TextField nombreCrudTF;
    @FXML
    public CheckBox campeonCrudCB;
    @FXML
    public DatePicker fechaCrudDP;
    @FXML
    public TextField fotoCrudTF;
    @FXML
    public Button crearBTN;
    @FXML
    public Button editarBTN;
    @FXML
    public Button eliminarBTN;
    @FXML
    public Button limpiarBTN;

    ObservableList<Equipo> equiposTV = FXCollections.observableArrayList();

    EquipoDAO  equipoDAO = new EquipoDAO();

    public boolean comprobarCampos(){
        return !(nombreCrudTF.getText().isEmpty() && fechaCrudDP.getValue()==null);
    }

    public void handleCerrarSesion(ActionEvent actionEvent) {
        if (Alertas.showConfirmationAlert("Cerrar sesión","¿Estás seguro de que quieres cerrar sesión?")){
            AppShell.getInstance().setUsuario(null);
            AppShell.getInstance().changeView(View.LOGIN);
        }
    }

    public void handleCrear(ActionEvent actionEvent) {
        if (comprobarCampos()){
            Equipo equipo = new Equipo(nombreCrudTF.getText(),campeonCrudCB.isSelected(),fechaCrudDP.getValue(),fotoCrudTF.getText());
            if (equipoDAO.crear(equipo)){
                Alertas.showStandardAlert("Éxito","Equipo creado correctamente", Alert.AlertType.INFORMATION);
                cargarEquipos();
                limpiarCampos();
            }
            else {
                Alertas.showStandardAlert("Error","Error creando equipo", Alert.AlertType.ERROR);
            }
        }
        else {
            Alertas.showStandardAlert("Error","Rellena los campos", Alert.AlertType.ERROR);
        }
    }

    public void handleEditar(ActionEvent actionEvent) {
        if (idCrudLabel.getText().isEmpty()) { return; }
        if (comprobarCampos()){
            Equipo equipo = new Equipo(Integer.parseInt(idCrudLabel.getText()),nombreCrudTF.getText(),campeonCrudCB.isSelected(),fechaCrudDP.getValue(),fotoCrudTF.getText());
            if (equipoDAO.editar(equipo)){
                Alertas.showStandardAlert("Éxito","Equipo editado", Alert.AlertType.INFORMATION);
                cargarEquipos();
                limpiarCampos();
            }
            else {
                Alertas.showStandardAlert("Error","Error editando equipo", Alert.AlertType.ERROR);
            }
        }
        else {
            Alertas.showStandardAlert("Error","Rellena los campos", Alert.AlertType.ERROR);
        }
    }

    public void handleEliminar(ActionEvent actionEvent) {
        if (idCrudLabel.getText().isEmpty()) { return; }
        if (comprobarCampos()){
            Equipo equipo = new Equipo(Integer.parseInt(idCrudLabel.getText()),nombreCrudTF.getText(),campeonCrudCB.isSelected(),fechaCrudDP.getValue(),fotoCrudTF.getText());
            if (Alertas.showConfirmationAlert("Borrar","¿Estás seguro de que deseas borrar?")){
                if (equipoDAO.eliminar(equipo)){
                    Alertas.showStandardAlert("Éxito","Equipo eliminado", Alert.AlertType.INFORMATION);
                    cargarEquipos();
                    limpiarCampos();
                }
                else {
                    Alertas.showStandardAlert("Error","Error eliminando equipo", Alert.AlertType.ERROR);
                }
            }

        }
        else {
            Alertas.showStandardAlert("Error","Rellena los campos", Alert.AlertType.ERROR);
        }
    }

    public void handleLimpiar(ActionEvent actionEvent) {

        limpiarCampos();

    }

    private void limpiarCampos() {
        idCrudLabel.setText("");
        nombreCrudTF.setText("");
        campeonCrudCB.setSelected(false);
        fechaCrudDP.setValue(null);
        fotoCrudTF.setText("");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        usuarioLogueadoLabel.setText(AppShell.getInstance().getUsuario().getUsername());

        if (!AppShell.getInstance().getUsuario().isAdmin()) {
            crearBTN.setVisible(false);
            editarBTN.setVisible(false);
            eliminarBTN.setVisible(false);
        }

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        campeonColumn.setCellValueFactory(new PropertyValueFactory<>("campeon"));
        fechaColumn.setCellValueFactory(new PropertyValueFactory<>("fecha_fundacion"));
        fotoColumn.setCellValueFactory(new PropertyValueFactory<>("foto_url"));

        cargarEquipos();

        tablaEquiposTV.getSelectionModel().selectedItemProperty().addListener((observableValue, oldEquipo, equipo) -> {
            rellenarCampos(equipo);
        });






    }

    private void rellenarCampos(Equipo equipo) {
        if (equipo != null) {
            idCrudLabel.setText(String.valueOf(equipo.getId()));
            nombreCrudTF.setText(equipo.getNombre());
            campeonCrudCB.setSelected(equipo.isCampeon());
            fechaCrudDP.setValue(equipo.getFecha_fundacion());
            fotoCrudTF.setText(equipo.getFoto_url());
        }
    }

    private void cargarEquipos() {
        List<Equipo> equipos = equipoDAO.findAll();
        equiposTV.setAll(equipos);
        tablaEquiposTV.setItems(equiposTV);
    }
}
