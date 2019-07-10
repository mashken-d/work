import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Readers } from '../readers';
import { ReadersService } from '../readers.service';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-readers',
  templateUrl: './readers.component.html',
  styleUrls: ['./readers.component.css']
})
export class ReadersComponent implements OnInit {
  reader = new Readers();
  readers: Observable<Readers[]>;

  constructor(private readersService: ReadersService) { }

  public readersFormGroup: FormGroup = new FormGroup ({
    _id : new FormControl (''),
    _card : new FormControl (''),
    _name : new FormControl (''),
    _address : new FormControl (''),
    _phone : new FormControl ('')
  })

  public readersFormGroupUpdate: FormGroup = new FormGroup ({
    _idUpdate : new FormControl (''),
    _cardUpdate : new FormControl (''),
    _nameUpdate : new FormControl (''),
    _addressUpdate : new FormControl (''),
    _phoneUpdate : new FormControl ('')
  })

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.readers = this.readersService.getReadersList();
  }

  createReader() {
    console.log('reader create modal btn wsas clicked')

    this.reader.fl_name = this.readersFormGroup.get('_name').value;
    this.reader.id_card = this.readersFormGroup.get('_card').value;
    this.reader.address = this.readersFormGroup.get('_address').value;
    this.reader.phone = this.readersFormGroup.get('_phone').value;

    console.log(this.reader);

    this.readersService.createReaders(this.reader).subscribe(
      data => console.log(data), error => console.log(error)
    );

    this.reloadData();
  }

  preparedData(reader: Readers) {
   console.log(reader);
    if (reader.fl_name!=null) {
      this.readersFormGroupUpdate.get('_nameUpdate').setValue(reader.fl_name);
    }
    if (reader.id_card!=null) {
      this.readersFormGroupUpdate.get('_cardUpdate').setValue(reader.id_card);
    }
    if (reader.address!=null) {
      this.readersFormGroupUpdate.get('_addressUpdate').setValue(reader.address);
    }
    if (reader.phone!=null) {
      this.readersFormGroupUpdate.get('_phoneUpdate').setValue(reader.phone);
    }
    this.readersFormGroupUpdate.get('_idUpdate').setValue(reader.id);
  }

  updateReader() {
    this.reader.fl_name = this.readersFormGroupUpdate.get('_nameUpdate').value;
    this.reader.id_card = this.readersFormGroupUpdate.get('_cardUpdate').value;
    this.reader.address= this.readersFormGroupUpdate.get('_addressUpdate').value;
    this.reader.phone = this.readersFormGroupUpdate.get('_phoneUpdate').value;
    this.reader.id = this.readersFormGroupUpdate.get('_idUpdate').value;

    this.readersService.updateReaders(this.reader).subscribe(data =>
      console.log(data),
      error => console.log(error));

    this.reloadData();
  }

  deleteReader(id: number) {
    this.readersService.deleteReaders(id).subscribe(data => {
      console.log(data);
      this.reloadData();
    }, 
    error => console.log(error));
  
    console.log("Reader was deleting")
    this.reloadData();
  }
  

}
