<div>
Prospect View: <br>
	<div style="display: table">
		<div style="display: table-row;">
			<div style="display: table-cell;text-align: right;">
				<md-button class="md-button md-raised md-primary button-override" ng-click="vm.showDialog($event, 0)">add new</md-button>
			</div>			
		</div>
		<div style="display: table-row;">
			<div style="display: table-cell">
				<table>
					<tr>						
						<td>Last Name</td>
						<td>Middle Name</td>
						<td>First Name</td>
						<td>Email</td>
						<td>Birthdate</td>
						<td>City</td>
						<td>Province</td>
						<td>Date Created</td>
						<td>Created By</td>
						<td>Date Updated</td>
						<td>Updated By</td>
					</tr>
					<tr ng-repeat="p in vm.persons" ng-dblclick="vm.showDialog($event,p.personId)" title="Click row to update">
						<td>{{p.lastName}}</td>
						<td>{{p.middleName}}</td>
						<td>{{p.firstName}}</td>
						<td>{{p.email}}</td>
						<td>{{p.birthDate | date: 'yyyy-MM-dd'}}</td>
						<td>{{p.cityOrMunicipality}}</td>
						<td>{{p.province}}</td>
						<td>{{p.dateCreated | date: 'yyyy-MM-dd HH:mm:ss'}}</td>
						<td>{{p.createdBy}}</td>
						<td>{{p.dateUpdated | date: 'yyyy-MM-dd HH:mm:ss'}}</td>
						<td>{{p.updatedBy}}</td>
						
					</tr>
				</table>
			</div>
		</div>
	</div>
</div>