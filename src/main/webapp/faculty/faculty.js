// An icon to show delete action
const deleteIcon = '<i class="fa fa-trash"></i>';

const manageFaculty = {

    saveData(key, myLibrary) {
        // Persistently store the data
        localStorage.setItem(key, JSON.stringify(myLibrary));
    },

    getLibrary(key) {

        // data format: [{title:"...", name:"...", ....},]
        let data = localStorage.getItem(key) ?
            JSON.parse(localStorage.getItem(key)) : [];
        return data;
    },

    updateChanges(storageKey, identifier, myLibrary) {
        this.saveData(storageKey, myLibrary);
        this.clearTable(identifier);
        this.render(myLibrary);
    },

    addToLibrary(myLibrary, data, storageKey, identifier) {
        myLibrary.push(data);
        this.updateChanges(storageKey, identifier, myLibrary);
    },

    removeFromLibrary(myLibrary, id, storageKey, identifier) {
        myLibrary.splice(id, 1);
        this.updateChanges(storageKey, identifier, myLibrary);
    },

    clearTable(identifier) {
        // delete all displayed records
        let library = document.querySelector(identifier);
        while (library.firstChild) {
            library.removeChild(library.firstChild);
        }
    },

    deleteLibrary(key) {
        localStorage.removeItem(key);
        myLibrary = getLibrary(key);
        this.clearTable(key);
        this.render(myLibrary);
    },

    // Event listeners
    hideModal() {
        let modal = document.querySelector(".add-modal");
        modal.style.display = 'none';
    },

    showModal() {
        let modal = document.querySelector(".add-modal");
        modal.style.display = 'block';
    },

    createNewFaculty() {
        let title = document.querySelector("#title").value;
        let name = document.querySelector("#name").value;
        let institution = document.querySelector("#institution").value;
        let department = document.querySelector("#department").value;

        return { title: title, name: name, institution: institution, department: department };

    },

    render(myLibrary) {
        let facultyList = document.querySelector("#fac-list");

        // display all
        myLibrary.forEach((faculty, id) => {
            let facultyInfo = document.createElement('tr');
            let facultyKeys = Object.keys(faculty); // A list of object keys
            facultyKeys.push("delete"); // add delete key

            //
            facultyKeys.forEach((key) => {
                let entry = document.createElement('td');
                if (key == "delete") {
                    entry.innerHTML = deleteIcon;
                    entry.classList.add('delete');
                    entry.setAttribute("data-id", id);

                    entry.addEventListener('click', function() {
                        manageFaculty.removeFromLibrary(myLibrary, entry.dataset.id, "faculty", "#fac-list");
                    });

                } else {
                    entry.innerHTML = faculty[key];
                }
                facultyInfo.appendChild(entry);
            });

            facultyList.appendChild(facultyInfo);
        });

    },

    start() {
        let STORAGE_KEY = "faculty";
        let myLibrary = this.getLibrary(STORAGE_KEY);

        let addBtn = document.querySelector("#add-btn");
        addBtn.addEventListener("click", function() {
            manageFaculty.showModal();
        });

        let closeBtn = document.querySelector(".close");
        closeBtn.addEventListener("click", function() {
            manageFaculty.hideModal();
        });

        this.render(myLibrary);

        let addInfo = document.querySelector("#fac-info-form");
        addInfo.addEventListener("submit", function(e) {
            // prevent default submit action which sends data to a server
            e.preventDefault();
            let faculty = manageFaculty.createNewFaculty();
            manageFaculty.addToLibrary(myLibrary, faculty, STORAGE_KEY, "#fac-list");
            manageFaculty.hideModal();
        });
    }

}

manageFaculty.start();